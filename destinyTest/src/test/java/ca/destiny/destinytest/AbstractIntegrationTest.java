package ca.destiny.destinytest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public abstract class AbstractIntegrationTest {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final ClassLoader classLoader = getClass().getClassLoader();


    protected <T> List<T> loadListFromFile(String fileName, TypeReference<List<T>> typeReference) throws URISyntaxException, IOException {
        var uri = classLoader.getResource(fileName).toURI();
        Path path = Paths.get(uri);
        String output = Files.readString(path);
        return objectMapper.readValue(output, typeReference);
    }

    protected <T> T loadPojoFromFile(String fileName, Class<T> aClass) throws URISyntaxException, IOException {
        URL resource = getClass().getClassLoader().getResource(fileName);
        Path path = Paths.get(resource.toURI());
        String output = Files.readString(path);
        return objectMapper.readValue(output, aClass);
    }

    protected <T> void writeData(T pojo, String fileName) throws IOException, URISyntaxException {
        String uri = this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI().toURL().toString() + fileName;
        String json = objectMapper.writeValueAsString(pojo);
        Path filePath = Path.of(fileName);
        Files.writeString(filePath, json);
    }

}
