
import java.util.Objects;

public class CollectiveMemberships {
    private Collective collective;

    public CollectiveMemberships() {
    }

    public CollectiveMemberships(Collective collective) {
        this.collective = collective;
    }

    public Collective getCollective() {
        return collective;
    }

    public void setCollective(Collective collective) {
        this.collective = collective;
    }

    @Override
    public String toString() {
        return "CollectiveMemberships{" +
                "collective=" + collective +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollectiveMemberships that = (CollectiveMemberships) o;
        return Objects.equals(collective, that.collective);
    }

    @Override
    public int hashCode() {
        return Objects.hash(collective);
    }
}
