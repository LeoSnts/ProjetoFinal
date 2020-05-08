package santos.leonardo.databasemanha.model;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString

// JPA - Java Persistence API
@Entity
@Table(name= "morador")
public class MoradorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_morador")
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "rg")
    private double rg;


}//fim

// Mapeamento de JPA
// Como se fosse o DAO no PHP..
// aqui ele indica onde cada dado irá entrar...
