//made by copilot to fix the array collection thing
public interface CollectionInterface<T>
{
  boolean add(T element);

  boolean remove(T target);

  boolean contains(T target);

  T get(T target);

  boolean isFull();

  boolean isEmpty();

  int size();
}
