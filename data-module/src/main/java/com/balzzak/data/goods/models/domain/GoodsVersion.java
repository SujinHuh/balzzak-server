package com.balzzak.data.goods.models.domain;

import com.balzzak.common.utils.DatetimeHelper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class GoodsVersion {

    public void setCurrentDatetime() {
        this.createDate = DatetimeHelper.timestampNow();
        this.updateDate = DatetimeHelper.timestampNow();
    }

    public void update(GoodsVersion goodsVersion) {
        this.filePath = goodsVersion.getFilePath();
        this.updateDate = DatetimeHelper.timestampNow();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long versionId;

    @Column(nullable = false)
    private String filePath;

    @Column(nullable = false)
    private Timestamp createDate;

    @Column(nullable = false)
    private Timestamp updateDate;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "versionId")
    private List<Goods> goodsList;
}
