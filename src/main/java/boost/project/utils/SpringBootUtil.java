package boost.project.utils;

import static boost.project.utils.ConfigConstants.BOOT_VERSION_ATTRIBUTE;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import org.apache.commons.io.FileUtils;

import boost.project.BoostException;

public class SpringBootUtil {
    
    private boolean isSpringBootUberJar(File artifact) throws IOException {
        try (JarFile jarFile = new JarFile(artifact)) {
            Manifest manifest = jarFile.getManifest();
            return (manifest != null && manifest.getMainAttributes()
                    .getValue(BOOT_VERSION_ATTRIBUTE) != null);
        }
    }
    
    public String getSpringBootUberJarPath(File artifact) throws BoostException {
        try {
            return artifact.getCanonicalFile().getPath() + ".spring";
        } catch (IOException e) {
            throw new BoostException("Error getting Spring Boot uber JAR path.", e);
        }
    }

    public void copySpringBootUberJar(File artifact) throws BoostException {
        try {
            File springJar = new File(getSpringBootUberJarPath(artifact));
            // Delete the old Spring Boot uber JAR
            /*if(springJar.exists()) {
                springJar.delete();
            }
            */
            
            // We are sure the artifact is a Spring Boot uber JAR if it has Spring-Boot-Version in the manifest, but not a wlp directory
            if(isSpringBootUberJar(artifact) && !BoostUtil.isLibertyJar(artifact)) {
                FileUtils.copyFile(artifact, springJar);
            }
        } catch (IOException e) {
            throw new BoostException("Error copying Spring Boot uber JAR.", e);
        }
    }
    
    public void addSpringBootVersionToManifest(File artifact) throws BoostException {
        Map<String, String> env = new HashMap<>(); 
        env.put("create", "true");
        // locate file system by using the syntax 
        // defined in java.net.JarURLConnection
        Path path = artifact.toPath();

       try (FileSystem zipfs = FileSystems.newFileSystem(path, getClass().getClassLoader())) {
            //Path externalTxtFile = Paths.get("/codeSamples/zipfs/SomeTextFile.txt");
            Path zipPath = zipfs.getPath("/META-INF/MANIFEST.MF");
            
            InputStream is = Files.newInputStream(zipPath);
            
            Manifest manifest = new Manifest(is);
            manifest.getMainAttributes().put(new Attributes.Name(BOOT_VERSION_ATTRIBUTE), "1"); // Just put something here
            
            ByteArrayOutputStream manifestOs = new ByteArrayOutputStream();
            manifest.write(manifestOs);
            InputStream manifestIs = new ByteArrayInputStream(manifestOs.toByteArray()); 
            Files.copy(manifestIs, zipPath, StandardCopyOption.REPLACE_EXISTING);
            
        } catch(IOException e) {
            throw new BoostException("Error updating manifest file.", e);
        }
    }
    
}
