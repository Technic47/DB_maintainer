package ru.kuznetsov.db_maintainer.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Comment")
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentEntity extends AbstractEntity {
    @Column(name = "text")
    private String text;
    @Column(name = "author")
    private String author;
    @Column(name = "publish_date")
    private Date publishDate;
}
