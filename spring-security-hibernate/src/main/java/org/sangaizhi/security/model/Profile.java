package org.sangaizhi.security.model;

import org.sangaizhi.security.constants.UserProfileType;

import javax.persistence.*;

/**
 * 用户画像（角色）
 * @author sangaizhi
 * @date 2017/7/10
 */
@Entity
@Table(name = "t_profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type", length = 15, unique = true, nullable = false)
    private Integer type = UserProfileType.USER.getValue();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Profile that = (Profile) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return type != null ? type.equals(that.type) : that.type == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", type=" + type +
                '}';
    }
}
