package com.chenhm.springboot.test;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 地理位置表
 * 
 * @author chen-hongmin
 * @email Hongmin.Chen1@geely.com
 * @date 2018-10-08 14:03:22
 */
@Data
public class CntLocationPoiDO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**主键id*/
	private Long id;

	/**业务Id*/
	private String locationCode;

	/**地理名称*/
	private String locationName;

	/**详细地址*/
	private String locationAddress;

	/**经度*/
	private Double longitude;

	/**纬度*/
	private Double latitude;

	/**城市编码*/
	private String cityCode;

	/**城市名称*/
	private String cityName;

	/**创建时间*/
	private Date createTime;

	/**修改时间*/
	private Date updateTime;

	/**0未删除，1删除*/
	private Integer delFlag;

}
