package sms.filestore;

import sms.model.Entity;
import sms.persistence.PersistenceException;
import sms.persistence.PersistenceService;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersistenceServiceImpl implements PersistenceService {

    private final Path dataPath = Paths.get("", "data");

    @Override
    public <T extends Entity> List<T> list(Class<T> type) throws PersistenceException {
        List<T> results = new ArrayList<>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(getEntitiesPath(type), "*.bin")) {
            for (Path path : directoryStream) {
                results.add(readEntity(path));
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new PersistenceException(e);
        }
        return results;
    }

    @Override
    public <T extends Entity> Optional<T> get(Class<T> type, String id) throws PersistenceException {

        Path path = getEntityPath(type ,id);
        try {
            Entity entity = readEntity(path);
            return (Optional<T>) Optional.of(entity);
        } catch (IOException | ClassNotFoundException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public Entity save(Entity entity) throws PersistenceException {
        try {
            Entity entity1 = saveEntity(entity);
            System.out.println("entity1: " + entity1);
            return entity1;
        } catch (IOException e) {
            throw new PersistenceException(e);
        }
    }

    @Override
    public <T extends Entity> void delete(Class<T> type, String id) throws PersistenceException {
        try {
            deleteEntity(type, id);
        } catch (IOException e) {
            throw new PersistenceException(e);
        }
    }

    private Path getEntitiesPath(Class<?> type) {
        return dataPath.resolve(type.getSimpleName());
    }

    private Path getEntityPath(Class<?> type, String id) {
        return getEntitiesPath(type).resolve(String.format("%s.bin", id));
    }

    private <T extends Entity> T readEntity(Path path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path))) {
            return (T) objectInputStream.readObject();
        }
    }

    private Entity saveEntity(Entity entity) throws IOException {
        Path path = getEntityPath(entity.getClass(), entity.getId());
        if (Files.notExists(path)) {
//            System.out.println("path: " + path.toAbsolutePath().toString());
            Files.createDirectories(path.toAbsolutePath().getParent());
            Files.createFile(path);
        }
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(path))) {
            objectOutputStream.writeObject(entity);
        }
        return entity;
    }

    private void deleteEntity(Class<?> type, String id) throws IOException {
        Files.deleteIfExists(getEntityPath(type, id));
    }
}
