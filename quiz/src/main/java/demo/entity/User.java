package demo.entity;

/**
 * The type User.
 */
public class User {
    private long id;
    private String name;

    /**
     * Instantiates a new User.
     * @param id   the id
     * @param name the name
     */
    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Gets id.
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets id.
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets name.
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }
}
