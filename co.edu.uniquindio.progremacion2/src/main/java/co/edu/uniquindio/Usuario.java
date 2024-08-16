public record Usuario(String nombre, String edad, String id) {
    public Usuario {
        assert nombre != null;
        assert edad != null;
        assert id != null;
    }
}