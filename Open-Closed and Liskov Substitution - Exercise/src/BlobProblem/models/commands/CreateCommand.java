package BlobProblem.models.commands;

import BlobProblem.interfaces.Executable;
import BlobProblem.models.Blob;
import BlobProblem.models.factories.BlobFactory;
import Logger.annotations.Inject;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class CreateCommand implements Executable {

    public CreateCommand() {
    }

    @Inject
    private Map<String, Blob> blobMap;

    @Override
    public void execute(String[] data) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        String  name = data[1];
        int health = Integer.parseInt(data[2]);
        int damage = Integer.parseInt(data[3]);
        String behavior = data[4];
        String attack = data[5];
        Blob blob = BlobFactory.createBlob(name, health, damage, behavior, attack);
        this.blobMap.put(name, blob);
    }
}
