package HA_10;

import org.junit.Assert;
import org.junit.Test;
import org.testcontainers.containers.DockerComposeContainer;

import java.io.File;

/**
 * Created by Maynor Teleguario
 * 30247228
 * Design Patterns Summer Semester 2019
 * Homework No 10
 * University of Kassel
 */
public class ComposeContainerTest {

   @Test
   public void testContainer(){
       System.out.println("***********************************************");
       System.out.println("|                                             |");
       System.out.println("|                 TEST BEGINN                 |");
       System.out.println("|                                             |");
       System.out.println("***********************************************");

       DockerComposeContainer compose = new DockerComposeContainer(new File("src/main/java/HA_09/docker-compose.yml"))
               .withExposedService("shopserver", 5001)
               .withExposedService("warehouseserver", 5002)
               .withLocalCompose(true);
       File composeFile = new File("src/main/java/HA_10/docker-compose.yml");
       File shopDockerfile = new File("src/main/java/HA_10/DockerShop/Dockerfile");
       File warehoouseDockerfile = new File("src/main/java/HA_10/DockerWarehouse/Dockerfile");
       Assert.assertTrue(shopDockerfile.exists());
       Assert.assertTrue(warehoouseDockerfile.exists());
       Assert.assertTrue(composeFile.exists());

       System.out.println("******************** ***************************");
       System.out.println("|                                             |");
       System.out.println("|                 TEST END                    |");
       System.out.println("|                                             |");
       System.out.println("***********************************************");
   }
}
