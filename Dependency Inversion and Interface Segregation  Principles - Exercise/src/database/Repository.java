package database;

import Utility.Constants;
import contracts.IModelable;
import contracts.IRepository;
import exceptions.DuplicateModelException;
import exceptions.NonExistantModelException;

import java.util.HashMap;

public class Repository<T extends IModelable> implements IRepository<T> {
    private HashMap<String, T> itemsByModel;

    public Repository() {
        this.setItemsByModel(new HashMap<>());
    }

    private void setItemsByModel(HashMap<String, T> itemsByModel) {
        this.itemsByModel = itemsByModel;
    }

    @Override
    public void Add(T item) throws DuplicateModelException {
        if (this.itemsByModel.containsKey(item.getModel()))
            throw new DuplicateModelException(Constants.DuplicateModelMessage);

        this.itemsByModel.put(item.getModel(), item);
    }

    @Override
    public T GetItem(String model) throws NonExistantModelException {
        if (!this.itemsByModel.containsKey(model))
            throw new NonExistantModelException(Constants.NonExistantModelMessage);

        return this.itemsByModel.get(model);
    }

}
