package ca.destiny.destinytest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public abstract class AbstractIntegration {
    public static final String CLASSPATH = "classpath:";
    public static final String SRC_TEST_RESOURCES = "src/test/resources/";
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final ClassLoader classLoader;

    public AbstractIntegration(Class<?> aClass) {
        classLoader = aClass.getClassLoader();
    }


    protected <T> List<T> loadListFromFile(String fileName, TypeReference<List<T>> typeReference) throws URISyntaxException, IOException {
        String input = Files.readString(Path.of(SRC_TEST_RESOURCES + fileName));
        return objectMapper.readValue(input, typeReference);
    }

    protected <T> List<T> loadListFromFileOld(String fileName, TypeReference<List<T>> typeReference) throws URISyntaxException, IOException {
        URL resource = AbstractIntegration.class.getClassLoader().getResource(fileName);
//        String output = new Scanner(new File(resource.getFile())).next();

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
        String json = objectMapper.writeValueAsString(pojo);
        Path filePath = Path.of(SRC_TEST_RESOURCES + fileName);
        Files.writeString(filePath, json);
    }

}
