package snakeproject;

public interface Subject {

    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener);

    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener);

    public void notifyAllProperties();
}
