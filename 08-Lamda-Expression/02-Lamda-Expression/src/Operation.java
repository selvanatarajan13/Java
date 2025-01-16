
@FunctionalInterface // This annotation is used to indicate this interface is a functional interface to the c
public interface Operation<T> {
    T operate(T value1, T value2);
}
