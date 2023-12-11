package bouzhar.aftas.demo.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor

public class RankId implements Serializable {

    @ManyToOne
    private Competition competition;

    @ManyToOne
    private Member member;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RankId rankId = (RankId) o;
        return Objects.equals(competition, rankId.competition) && Objects.equals(member, rankId.member);
    }

    @Override
    public int hashCode() {
        return Objects.hash(competition, member);
    }
}
