import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class APIError {
    private int error_id;
    private String error_message;
    private String error_name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        APIError apiError = (APIError) o;
        return Objects.equals(error_id, apiError.error_id) && Objects.equals(error_message, apiError.error_message) && Objects.equals(error_name, apiError.error_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(error_id, error_message, error_name);
    }

    @Override
    public String toString() {
        return "APIError{" +
                "error_id='" + error_id + '\'' +
                ", error_message='" + error_message + '\'' +
                ", error_name='" + error_name + '\'' +
                '}';
    }

    public int getError_id() {
        return error_id;
    }

    public void setError_id(int error_id) {
        this.error_id = error_id;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public String getError_name() {
        return error_name;
    }

    public void setError_name(String error_name) {
        this.error_name = error_name;
    }

    public APIError() {
    }

    public APIError(int error_id, String error_message, String error_name) {
        this.error_id = error_id;
        this.error_message = error_message;
        this.error_name = error_name;
    }
}
