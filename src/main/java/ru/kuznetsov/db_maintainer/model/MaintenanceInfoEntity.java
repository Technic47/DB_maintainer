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
@Table(name = "maintain_info")
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceInfoEntity extends AbstractEntity{
    @Column(name = "comment_limit")
    private Integer commentLimit;
    @Column(name = "excess_amount_removed")
    private Integer excessAmountRemoved;
    @Column(name = "maintenance_time_stamp")
    private Date maintenanceTimeStamp;
}
