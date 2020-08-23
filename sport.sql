create database sport;

DROP TABLE IF EXISTS `admininfo`;
--管理员表--
CREATE TABLE `admininfo` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,  --管理员id编号--
  `aname` varchar(100) COLLATE utf8_bin NOT NULL, --管理员用户名--
  `pwd` varchar(100) COLLATE utf8_bin NOT NULL,--密码--
  `email` varchar(20) COLLATE utf8_bin DEFAULT NULL,--邮箱号--
  PRIMARY KEY (`aid`),--主键--
  UNIQUE KEY `aname` (`aname`),--用户名唯一--
  UNIQUE KEY `pwd` (`email`)   --邮箱唯一--
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

insert into admininfo values(0,'nll',md5('123'),'2911337127@qq.com');
--用户表--
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,--用户id--
  `email` varchar(20) COLLATE utf8_bin NOT NULL,--用户邮箱--
  `pwd` varchar(100) COLLATE utf8_bin NOT NULL,--密码--
  `uname` varchar(15) COLLATE utf8_bin NOT NULL,--昵称--
  `photo` varchar(100) COLLATE utf8_bin NOT NULL,--头像--
  `status` int(11) DEFAULT 1,--状态 1:正常 状态2：注销 3：拉黑--
  PRIMARY KEY (`uid`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `uname` (`uname`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO userinfo VALUES ('1','2911337127@qq.com',md5('123'),'小嗨皮','images/nll.png',1);
INSERT INTO userinfo VALUES ('2','346888934@qq.com',md5('123321'),'香格里拉','images/nll4.png',1);
INSERT INTO userinfo VALUES ('3','24884829@qq.com',md5('123321'),'fell','images/nll5.jpg',2);
INSERT INTO userinfo VALUES ('4','4672777221@qq.com',md5('12321'),'备忘录','images/nll6.jpeg',1);
INSERT INTO userinfo VALUES ('5','2344554311@qq.com',md5('1221'),'小恶龙','images/nll1.jpeg',1);
INSERT INTO userinfo VALUES ('6','232454301@qq.com',md5('1221'),'天马不能行空？','images/nll2.jpg',1);

--地址信息表--
DROP TABLE IF EXISTS `addrinfo`;
CREATE TABLE `addrinfo` ( 
  `aid` varchar(100) COLLATE utf8_bin NOT NULL,--主键--
  `uid` int(11) COLLATE utf8_bin NOT NULL,--用户id--
  `name` varchar(100) COLLATE utf8_bin NOT NULL,--收货人
  `tel` varchar(15) COLLATE utf8_bin NOT NULL,--联系电话
  `province` varchar(100) COLLATE utf8_bin NOT NULL,--省
  `city` varchar(100) COLLATE utf8_bin NOT NULL,--市
  `area` varchar(100) COLLATE utf8_bin NOT NULL,--县
  `addr` varchar(100) COLLATE utf8_bin NOT NULL,--详细地址
  `flag` int(11) DEFAULT NULL,--标注 1,默认地址;0,普通地址;
  `status` int(11) DEFAULT 1,--1,正常 ;0,删除;
  PRIMARY KEY (`aid`),
  KEY `FK_addrInfo_uid` (`uid`),
  CONSTRAINT `FK_addrInfo_uid` FOREIGN KEY (`uid`) REFERENCES `userinfo` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO addrinfo VALUES ('1','1','小嗨皮','18574778717','湖南省','衡阳市','蒸湘区','常胜大道28号南华大学',1,1);

--商品类型表
DROP TABLE IF EXISTS `goodstype`;
CREATE TABLE `goodstype` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `tname` varchar(100) COLLATE utf8_bin NOT NULL,
  `pic` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`tid`)
)ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

insert into goodstype VALUES (1,'运动上衣','../pics/1596428482370_o1.jfif');
insert into goodstype VALUES (2,'运动裤','images/goods/T2.png');
insert into goodstype VALUES (3,'运动套装','images/goods/o1.jfif');
insert into goodstype VALUES (4,'运动跑鞋','images/goods/o2.png');
insert into goodstype VALUES (5,'健康食品','images/goods/t4.jpg');
insert into goodstype VALUES (6,'减脂利器','images/goods/o4.png');

--商品属性表
DROP TABLE IF EXISTS `fieldinfo`;
CREATE TABLE `fieldinfo` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(100) COLLATE utf8_bin NOT NULL,--属性名--
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

insert into fieldinfo VALUES(1,'颜色');
insert into fieldinfo VALUES(2,'尺寸');
insert into fieldinfo VALUES(3,'材质');

--商品属性详细表

CREATE TABLE `fieldItemInfo` (
  `fiid` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11)  NOT NULL,--商品编号--
  `fid` int(11)  NOT NULL,--属性编号--
  `fvalue` varchar(40)  NOT NULL,--属性值--
  PRIMARY KEY (`fiid`),
  KEY `FK_fieldItemInfo_gid` (`gid`),
  KEY `FK_fieldItemInfo_fid` (`fid`),
  CONSTRAINT `FK_fieldItemInfo_gid` FOREIGN KEY (`gid`) REFERENCES `goodsinfo` (`gid`),
  CONSTRAINT `FK_fieldItemInfo_fid` FOREIGN KEY (`fid`) REFERENCES `fieldinfo` (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


insert into fieldIteminfo VALUES(1,1,1,'灰色');--1号商品的颜色属性灰色--
insert into fieldIteminfo VALUES(2,1,1,'蓝色');--1号商品的颜色属性为蓝色色--
insert into fieldIteminfo VALUES(3,1,2,'180cm');--1号商品尺寸--
insert into fieldIteminfo VALUES(4,1,2,'170cm');


--商品表
DROP TABLE IF EXISTS `goodsinfo`;
CREATE TABLE `goodsinfo` (
  `gid` int(11) NOT NULL AUTO_INCREMENT,
  `gname` varchar(100) COLLATE utf8_bin NOT NULL,
  `tid` int(11) DEFAULT NULL,
  `price` decimal(8,2) DEFAULT NULL,
  `intro` varchar(400) COLLATE utf8_bin DEFAULT NULL,
  `balance` int(11) DEFAULT NULL,
  `pics` varchar(1000) COLLATE utf8_bin DEFAULT NULL,
  `unit` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `weight` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `descr` text COLLATE utf8_bin,--商品参数描述
  `status` int(11) DEFAULT 1,--1,已上架 ;0,已下架;
  PRIMARY KEY (`gid`),
  KEY `FK_goodsInfo_tid` (`tid`),
  CONSTRAINT `FK_goodsInfo_tid` FOREIGN KEY (`tid`) REFERENCES `goodstype` (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO goodsinfo VALUES ('1', 'NIKE耐克短袖T恤男装', '1', '179.0', '2020夏季新款健身运动体恤半袖速干透气上衣', '100', 'images/goods01.jpg', '件','200g','品牌: Nike/耐克;功能: 吸湿排汗 速干 透气;材质: 棉涤;吊牌价: 349.00;款号: AQ9920-438-0_TadFE;上市时间: 2020年夏季;T恤款式: 短袖;服装版型: 常规;服装款式细节: 品牌LOGO;性别: 男;运动户外项目: 运动休闲;运动系列: 运动生活;',1);
INSERT INTO goodsinfo VALUES ('2', 'annerun瑜伽服女 ', '3', '189.0', '显瘦性感速干跑步健身房运动套装网红健身两件套', '60', 'images/goods02.jpg', '套','400g','款号: R66-7;上市时间: 2020年夏季;上装款式: 短袖;上装衣长: 及腰;性别: 女;运动户外项目: 瑜伽;下装裤长: 长裤',1);
INSERT INTO goodsinfo VALUES ('3', 'VFU前拉链运动内衣 ', '1', '159.0', '女防震防下垂小胸健身bra美背瑜伽文胸夏季薄款', '60', 'images/goods03.jpg', '件','200g','有无钢托: 无钢托;吊牌价: 308;上市时间: 2019年夏季;货号: TW7617;罩杯款式: 全罩杯;肩带样式: 固定双肩带;文胸款式: U型;文胸尺码: S M L;运动支撑强度: 中度支撑;',1);
INSERT INTO goodsinfo VALUES ('4', '途斯tpe瑜伽垫 ', '6', '91.0', '加厚加宽加长女健身垫防滑初学者瑜珈垫地垫子家用', '10', 'images/goods07.jpg', '件','200g','品牌: 途斯;材质: TPE;图案: 纯色;尺寸: 183cmX80cm 185cmx68cm 183CM*68CM;厚度: 6mm(初学者) 8mm(初学者) 10mm(初学者);上市时间: 2018年春季;货号: 途斯车轮纹TPE瑜伽垫;',1);
INSERT INTO goodsinfo VALUES ('5', '燕麦片水果早餐', '5', '33.9', '即食非减肥代餐食品健身粗粮非减脂瘦身无糖精脱脂,买1发3 再送碗勺 您的贴心早餐伴侣 ', '100', 'images/goods05.jpg', '件','200g','保质期：240 天;品牌: 枫情水岸;系列: 酸奶坚果水果燕麦片;包装种类: 罐装是否为有机食品: 否;原料成分: 燕麦;生产许可证编号：SC11837048101233;配送频次: 1周2次;净含量: 1500g;',1);
INSERT INTO goodsinfo VALUES ('6', '英国USN DietFuel减脂代餐营养纤维乳清蛋白粉1kg','5', '249.0', '美国品牌 菜鸟宁波保税7号仓发货', '100', 'images/goods06.jpg', '罐','200g','保质期：720 天;品牌: USN;系列: DietFuel;产地: 英国;适用性别: 通用;口味: 巧克力味 草莓味 香草味;保质期: 24个月;生产企业: USN(UK) Ltd;产品剂型: 粉剂;规格（粒/袋/ml/g）: 1000g;计价单位: 桶;用法: 每次两勺;适用人群: 成人;食用提示: 孕妇，儿童，哺乳期不建议使用;效期说明: 720天',1);
INSERT INTO goodsinfo VALUES ('7', 'VFU高腰弹力紧身裤 女', '2', '179.0', '女显瘦跑步裤子运动速干长裤瑜伽训练健身夏季', '60', 'images/goods04.jpg', '件','200g','品牌: vfu;功能: 吸湿排汗 速干 透气 超强弹性;尺码: S M L XL;腰型: 高腰;颜色分类: 网纱款晨绿色(春夏面料) 网纱款浅灰色(春夏面料) 网纱款蓝色(春夏面料) 无网纱深蓝色（四季面料） 无网纱黑色（四季面料） 收藏 vfu 加购;吊牌价: 326;款号: TK2546;上市时间: 2018年秋季;性别: 女;运动户外项目: 瑜伽 器械健身;裤长: 长裤；款式: 紧身裤',1);


DROP TABLE IF EXISTS `cartinfo`;
CREATE TABLE `cartinfo` (
  `cid` varchar(100) COLLATE utf8_bin NOT NULL,
  `uid` int(11) DEFAULT NULL,
  `gid` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `filed` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `FK_cartInfo_uid` (`uid`),
  KEY `FK_goodsInfo_gid` (`gid`),
  CONSTRAINT `FK_goodsInfo_gid` FOREIGN KEY (`gid`) REFERENCES `goodsInfo` (`gid`),
  CONSTRAINT `FK_cartInfo_uid` FOREIGN KEY (`uid`) REFERENCES `userinfo` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO cartinfo VALUES ('1', '1', '1', '6','红色大号');


DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo` (
  `oid` varchar(100) COLLATE utf8_bin NOT NULL,
  `odate` datetime DEFAULT NULL,--下单时间---
  `uid` int(11) COLLATE utf8_bin NOT NULL,--用户编号--
  `aid` varchar(100) COLLATE utf8_bin DEFAULT NULL,--地址编号--
  `sdate` datetime DEFAULT NULL,--发货时间--
  `rdate` datetime DEFAULT NULL,--送达时间--
  `status` int(11) DEFAULT NULL,--1,已下单 2,已付款 3,已发货 4,已完成
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `FK_orderInfo_aid` (`aid`),
  KEY `FK_orderInfo_uid` (`uid`),
  CONSTRAINT `FK_orderInfo_aid` FOREIGN KEY (`aid`) REFERENCES `addrinfo` (`aid`),
  CONSTRAINT `FK_orderInfo_uid` FOREIGN KEY (`uid`) REFERENCES `userinfo` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO orderinfo VALUES ('abc', '2020-8-02 15:56:13', '1', '1',null,null,1,128.0);
INSERT INTO orderinfo VALUES ('ubd', '2020-8-03 10:56:13', '1', '1',null,null,2,168.0);
INSERT INTO orderinfo VALUES ('obg', '2020-8-04 18:56:13', '1', '1',null,null,2,148.0);
INSERT INTO orderinfo VALUES ('abd', '2020-7-02 15:56:13', '1', '1',null,null,2,168.0);
INSERT INTO orderinfo VALUES ('hbg', '2020-7-09 18:56:13', '1', '1',null,null,2,148.0);
INSERT INTO orderinfo VALUES ('sbd', '2020-8-01 10:56:13', '1', '1',null,null,0,1268.0);
INSERT INTO orderinfo VALUES ('ubg', '2020-8-05 18:56:13', '1', '1',null,null,2,198.0);
INSERT INTO orderinfo VALUES ('uuu', '2020-7-02 15:56:13', '1', '1',null,null,2,168.0);
INSERT INTO orderinfo VALUES ('saa', '2020-7-09 18:56:13', '1', '1',null,null,2,148.0);
INSERT INTO orderinfo VALUES ('css', '2020-7-02 15:56:13', '1', '1',null,null,2,168.0);
INSERT INTO orderinfo VALUES ('yus', '2020-7-08 18:56:13', '1', '1',null,null,2,148.0);
INSERT INTO orderinfo VALUES ('uku', '2020-7-01 15:56:13', '1', '1',null,null,2,168.0);
INSERT INTO orderinfo VALUES ('nuh', '2020-7-06 18:56:13', '1', '1',null,null,2,148.0);
INSERT INTO orderinfo VALUES ('ch', '2020-7-05 15:56:13', '1', '1',null,null,2,168.0);
INSERT INTO orderinfo VALUES ('yss', '2020-7-04 18:56:13', '1', '1',null,null,2,148.0);
INSERT INTO orderinfo VALUES ('hdhd', '2020-7-19 18:56:13', '1', '1',null,null,2,548.0);
INSERT INTO orderinfo VALUES ('cde', '2020-7-22 15:56:13', '1', '1',null,null,2,468.0);
INSERT INTO orderinfo VALUES ('gnu', '2020-7-18 18:56:13', '1', '1',null,null,2,648.0);
INSERT INTO orderinfo VALUES ('lij', '2020-7-21 15:56:13', '1', '1',null,null,2,268.0);
INSERT INTO orderinfo VALUES ('unl', '2020-7-16 18:56:13', '1', '1',null,null,2,748.0);
INSERT INTO orderinfo VALUES ('nll', '2020-7-15 15:56:13', '1', '1',null,null,2,868.0);
INSERT INTO orderinfo VALUES ('cas', '2020-7-14 18:56:13', '1', '1',null,null,2,448.0);
INSERT INTO orderinfo VALUES ('caos', '2020-1-14 18:56:13', '1', '1',null,null,2,448.0);
INSERT INTO orderinfo VALUES ('chhs', '2019-9-14 18:56:13', '1', '1',null,null,2,890.0);

DROP TABLE IF EXISTS `orderiteminfo`;
CREATE TABLE `orderiteminfo` (
  `iid` int(11) NOT NULL AUTO_INCREMENT,
  `oid` varchar(100) COLLATE utf8_bin DEFAULT NULL,--订单编号--
  `gid` int(11) DEFAULT NULL,--商品编号--
  `nums` int(11) DEFAULT NULL,--购买数量--
  `price` decimal(10,2) DEFAULT NULL,--价格--
  `sdate` datetime DEFAULT NULL,--支付时间--
  `filed` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `comment` text DEFAULT NULL,--评论
  PRIMARY KEY (`iid`),
  KEY `FK_orderItemInfo_gid` (`gid`),
  KEY `FK_orderItemInfo_oid` (`oid`),
  CONSTRAINT `FK_orderItemInfo_gid` FOREIGN KEY (`gid`) REFERENCES `goodsinfo` (`gid`),
  CONSTRAINT `FK_orderItemInfo_oid` FOREIGN KEY (`oid`) REFERENCES `orderinfo` (`oid`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO orderiteminfo VALUES (1,'abc',5,2,67.8,'2019-9-14 18:56:13',1,null);
INSERT INTO orderiteminfo VALUES (1,abc,3,2,117.8,'2020-9-14 18:56:13',1,null);