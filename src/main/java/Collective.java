import java.util.List;
import java.util.Objects;

public class Collective {
    private List<String> tags;

    public Collective() {
    }

    public Collective(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getTags() {
        return tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collective that = (Collective) o;
        return Objects.equals(tags, that.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tags);
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
