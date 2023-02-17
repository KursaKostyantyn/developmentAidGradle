
import java.util.List;
import java.util.Objects;

public class ResponseDTO {
    private List<UserDTO> items;
    private boolean has_more;


    public ResponseDTO() {
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "items=" + items +
                ", has_more=" + has_more +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseDTO that = (ResponseDTO) o;
        return has_more == that.has_more && Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items, has_more);
    }

    public List<UserDTO> getItems() {
        return items;
    }

    public void setItems(List<UserDTO> items) {
        this.items = items;
    }

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public ResponseDTO(List<UserDTO> items, boolean has_more) {
        this.items = items;
        this.has_more = has_more;
    }
}
