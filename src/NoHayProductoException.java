public class NoHayProductoException extends Exception {
  public NoHayProductoException() {
    super("falta de stock.");
  }
}
