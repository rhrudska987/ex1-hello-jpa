package jpabasic.ex1hellojpa;

import org.hibernate.query.criteria.internal.ValueHandlerFactory;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

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

    public Team getTeam() {
        return team;
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this); //이걸 해줘야 1차캐시에서 값을 읽어올 수 있음
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", team=" + team +
                '}';
    }
}
