package jpabasic.ex1hellojpa;

import org.hibernate.query.criteria.internal.ValueHandlerFactory;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String username;

    /*private Integer age;

    @Enumerated(EnumType.STRING) //db에는 enum타입이 없기 때문에 enumerated를 사용해야 함, 그리고 STRING 필수
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP) //db는 date, time, timestamp를 구분하기 때문에 이걸 사용해야함
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate testLocalDate; //Temporal은 요즘 잘 안씀..
    private LocalDateTime testLocalDateTime;

    @Lob //db에 varchar를 넘는 큰 값을 넣을때, 사용
    private String description;

    @Transient //db에 추가하고 싶지 않으면 Transient사용
    private int temp;*/

    public Member(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /*public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }*/
}
