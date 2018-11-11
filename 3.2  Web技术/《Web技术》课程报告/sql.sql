-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.5.28 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 dangdb 的数据库结构
CREATE DATABASE IF NOT EXISTS `dangdb` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `dangdb`;


-- 导出  表 dangdb.d_admins 结构
CREATE TABLE IF NOT EXISTS `d_admins` (
  `AdminID` int(4) NOT NULL AUTO_INCREMENT,
  `LoginName` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`AdminID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- 正在导出表  dangdb.d_admins 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `d_admins` DISABLE KEYS */;
REPLACE INTO `d_admins` (`AdminID`, `LoginName`, `password`) VALUES
	(1, 'admin', 'admin'),
	(2, '1', '1');
/*!40000 ALTER TABLE `d_admins` ENABLE KEYS */;


-- 导出  表 dangdb.d_book 结构
CREATE TABLE IF NOT EXISTS `d_book` (
  `id` int(12) NOT NULL,
  `author` varchar(200) NOT NULL,
  `publishing` varchar(200) NOT NULL,
  `publish_time` varchar(50) NOT NULL,
  `word_number` varchar(15) DEFAULT NULL,
  `which_edtion` varchar(15) DEFAULT NULL,
  `total_page` varchar(15) DEFAULT NULL,
  `print_time` int(20) DEFAULT NULL,
  `print_number` varchar(15) DEFAULT NULL,
  `isbn` varchar(25) DEFAULT NULL,
  `author_summary` text NOT NULL,
  `catalogue` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 正在导出表  dangdb.d_book 的数据：~30 rows (大约)
/*!40000 ALTER TABLE `d_book` DISABLE KEYS */;
REPLACE INTO `d_book` (`id`, `author`, `publishing`, `publish_time`, `word_number`, `which_edtion`, `total_page`, `print_time`, `print_number`, `isbn`, `author_summary`, `catalogue`) VALUES
	(1, '俞敏洪', '西安交通大学出版社', '20140614', '175千字', '1', '288', 1, '32', 'ISBN 978-7-5442-2297-6', '　俞敏洪，新东方教育科技集团董事长兼总裁。', '第一次来车站 窗边的小豆豆'),
	(2, '\r\n\r\n俞敏洪', '西安交通大学出版社', '20140614', '1万', '1', '100', 1, '32', '12345678', '　俞敏洪，新东方教育科技集团董事长兼总裁。', '这真是一本好书啊'),
	(3, '周思成', '\r\n\r\n机械工业出版社', '20140614', '59万', '1', '100', 1, '32', 'ISBN 9787111395072', '十九岁在大学讲授四六级，二十岁来到新东方，从考研英语一路教到GRE，两度被评为新东方“集团优秀教师”，在新东方十五周年全国教师评选中获得第一名。', '这真是一本好书啊'),
	(4, '胡赛尼(Khaled Hosseini)', 'Riverhead Trade', '20140614', '1万', '1', '100', 1, '32', '12345678', '卡勒德·胡赛尼（KhaledHosseini），1965年生于喀布尔，后随父亲逃往美国。', '这真是一本好书啊'),
	(5, 'David Nicholls　', 'Random House', '20140614', '1万', '1', '100', 1, '32', '12345678', 'David Nicholls trained as an actor before making the switch towriting. He is the author of two previous novels--Starter For Tenand The Understudy.', '这真是一本好书啊'),
	(6, 'Solomon Northup', 'Penguin Classics', '20140614', '1万', '1', '100', 1, '32', '12345678', 'Thedetails of his life thereafter are unknown, but he is believedtohave died in Glen Falls, New York, around 1863.', '这真是一本好书啊'),
	(7, '\r\n\r\n（英）霍恩比　著，王玉章　等译', '\r\n\r\n商务印书馆', '20140614', '1万', '1', '100', 1, '32', '12345678', '《牛津高阶英语词典》开学习型词典之先河，专为非英语国家的英语学习者编纂，问世六十载以来，多番修订，惠人无数。其严谨实用的风格有口皆碑，销量亦始终领先于其他同类词典。', '这真是一本好书啊'),
	(8, '（英）梅厄　主编，王立弟　等译', '\r\n\r\n商务印书馆', '20140614', '1万', '1', '100', 1, '32', '12345678', '《朗文当代英语大辞典》的“大"在于其文化知识的广泛涉猎，犹如展开一部百科全书。除具备高级英语辞典的全部内容外，还增收了1.5万余文化词条和560余项文化注释。是使用者拓宽知识面、提高英语水平的首选。', '这真是一本好书啊'),
	(9, '英国剑桥大学出版社 编著', '\r\n\r\n外语教学与研究出版社', '20140614', '1万', '1', '100', 1, '32', '12345678', '《剑桥高阶英汉双解词典》，它收录词目及短语170,000余条，覆盖面广，集学习词典、搭配词典、习语词典、考试词典于一身，是中高级英语学习者及雅思、BEC考生的理想工具书。', '这真是一本好书啊'),
	(10, '\r\n\r\n马德高', '吉林出版集团有限责任公司', '20140614', '1万', '1', '100', 1, '32', '12345678', '本书对每篇课文中出现的长难句进行框架剖析，指点长难句的破解方法，培养您对长难句的感知、分析能力，同步增强您的阅读理解能力，提高翻译水平。', '这真是一本好书啊'),
	(11, '\r\n\r\n丁言仁　主编', '南京大学出版社', '20140614', '1万', '1', '100', 1, '32', '12345678', '该书是“高等学校英语专业规划教材”之一，该书以满期足英语专业本科阶段不同年级写作教学上的需要所编写的，其重点是议论文写作，', '这真是一本好书啊'),
	(12, '薄冰 主编', '\r\n\r\n开明出版社', '20140614', '1万', '1', '100', 1, '32', '12345678', '本书最主要的特点就是对语法点的讲解系统、全面，知识体系完备，对每一个语法点都尽可能讲得细致、透彻，以满足大学生日常学习语法，特别是参加各种英语考试的需要。书中还采用了旁注的形式，对一些细微的语法知-识进行了讲解，这样可以在不影响整体语法结构的情况下，最大限度地对全书的内容做很好的补充，可以拓宽学生的知识面。\r\n', '这真是一本好书啊'),
	(13, '（美）鲁基特 著，王淼 译', '陕西师范大学出版社', '20140614', '1万', '1', '100', 1, '32', '12345678', '职场英语白骨精，助你完成由菜鸟到高手的完美蜕变，汇集最经典、最全面、最实用的商务英语会话表达，200个精典短句，夯实你的基础。生动诠释“立竿见影”，700个高频商务话题，迅速提升你的职场含金量。 ', '这真是一本好书啊'),
	(14, '武玥，汪倩　编', '\r\n\r\n中山大学出版社', '20140614', '1万', '1', '100', 1, '32', '12345678', '本书是一本完全从零开始的英语入门教材。首先学习26个英语字母的读法和写法，然后开始学习和训练国际音标。发音部分是学习英语的重点，千万不能忽视。', '这真是一本好书啊'),
	(15, '（美）罗克特，王恩波 著', '外文出版社', '20140614', '1万', '1', '100', 1, '32', '12345678', '本书越过了“生存口语”的层次，深入到社会生活的细微之处。与同类型的书相比，拥有更广泛的话题、更生动的表达、更浓厚趣味。', '这真是一本好书啊'),
	(16, '\r\n\r\n［美］詹姆斯格雷克 著，高博 译', '\r\n\r\n人民邮电出版社', '20140614', '1万', '1', '100', 1, '32', '12345678', '作为《混沌》、《费曼传》、《越来越快》、《牛顿传》等畅销书的作者，格雷克不仅在书中细致还原了历史细节，通俗解释了各种理论，还生动刻画了几位不为大众所熟知的人物：可编程计算机先驱、超越时代的查尔斯巴贝奇，第一位程序员、诗人拜伦之女爱达拜伦，计算机科学之父、天妒英才的阿兰图灵，以及全书的主人公、信息论之父克劳德香农。', '这真是一本好书啊'),
	(17, '（美）沃伦 著，爱飞翔 译', '\r\n\r\n机械工业出版社', '20140614', '1万', '1', '100', 1, '32', '12345678', '在本书中，作者给我们带来了一大批极为诱人的知识，其中包括各种节省程序运行时间的技巧、算法与窍门。学习了这些技术，程序员就可写出优雅高效的软件，同时还能洞悉其中原理。这些技术极为实用，而且其问题本身又非常有趣，有时甚至像猜谜解谜一般，需要奇思妙想才行。简而言之，软件开发者看到这些改进程序效率的妙计之后，定然大喜。', '这真是一本好书啊'),
	(18, '（美）帕特森，（美）亨尼斯　著，康继昌，樊晓桠，安建峰　等译', '机械工业出版社', '20140614', '1万', '1', '100', 1, '32', '12345678', '本书采用MIPS处理器作为展示计算机硬件技术、汇编语言、计算机算术、流水线、存储器层次结构以及I/O等基本功能的核心。书中强调了计算机从串行到并行的最新革新，在每章中都纳入了并行硬件和软件的主题，以软硬件协同设计发挥多核性能为最终目标。', '这真是一本好书啊'),
	(19, '（美）西尔伯沙茨　等著,杨冬青　等译', '\r\n\r\n机械工业出版社', '20140614', '1万', '1', '100', 1, '32', '12345678', '本书内容丰富，不仅讨论了关系数据模型和关系语言、数据库设计过程、关系数据库理论、数据库应用设计和开发、数据存储结构、数据存取技术、查询优化方法、事务处理系统和并发控制、故障恢复技术、数据仓库和数据挖掘，而且对性能调整、性能评测标准、数据库应用测试和标准化、空间和地理数据、时间数据、多媒体数据、移动和个人数据库管理以及事务处理监控器、事务工作流、电子商务、高性能事务系统、实时事务系统和持续长时间的事务等高级应用主题进行了广泛讨论。', '这真是一本好书啊'),
	(20, '秦靖，刘存勇 著', '\r\n\r\n机械工业出版社', '20140614', '1万', '1', '100', 1, '32', '12345678', 'Oracle 11g是甲骨文精心打造的最新的Oracle数据库版本，该版本数据库凝聚了Oracle30多年的精华。本书不仅是一本Oracle 11g的入门教材也是初学者快速掌握Oracle 11g的捷径。本书以Oracle11g为例，一共分为四篇，循序渐进的讲述了Oracle11g的基本语法和基本操作，从数据库的安装开始逐步介绍与数据库交互的语句以及管理数据库中的文件、备份与恢复数据库等操作。在数据库应用篇中还结合.NET和JAVA的编程环境讲解了如何连接Oracle11g数据库。', '这真是一本好书啊'),
	(21, '王雨竹　等编著', '\r\n\r\n机械工业出版社', '20140614', '1万', '1', '100', 1, '32', '12345678', '以初学者为核心，全面讲解MySQL数据库技术。在内容安排上由浅入深，让读者循序渐进地掌握编程技术；在内容讲解上结合丰富的图解和形象的比喻，帮助读者理解晦涩难懂的技术；在内容形式上附有大量的注意、技巧、说明等栏目，以提高读者的编程技术，丰富读者的编程经验。《', '这真是一本好书啊'),
	(22, '（美）Aaron Hillegass 著，夏伟频　译，李骏　审校', '\r\n\r\n华中科技大学出版社', '20140614', '1万', '1', '100', 1, '32', '12345678', '本书讲述Objective-C编程语言和基本的iOS/Mac开发知识。作者首先从基本的编程概念讲起（变量、条件语句、循环结构等），接着用浅显易懂的语言讲解Objective-C和Foundation的知识，包括Objective-C的基本语法、Foundation常用类、内存管理、常用设计模式等，最后手把手教读者编写完整的、基于事件驱动的iOS/Mac应用。书中还介绍了Objetive-C的高级内容，包括属性、范畴和Block对象等知识。全书篇幅精炼，内容清晰，适合无编程经验的读者入门学习。', '这真是一本好书啊'),
	(23, '明日科技　编著', '\r\n\r\n清华大学出版社', '20140614', '1万', '1', '100', 1, '32', '12345678', '通过通俗易懂的语言，丰富多彩的实例，详细介绍了使用VisualC++ 6.0（部分使用TurboC）进行C语言应用程序开发应该掌握的各方面技术。全书共分14章，包括初识C语言、C语言基础、顺序与选择结构程序设计、循环控制、数组、函数、指针、结构体与共用体、算法、位运算、预处理、文件、图形图像、商品信息管理系统。', '这真是一本好书啊'),
	(24, '\r\n\r\n李宁 编著', '\r\n\r\n人民邮电出版社', '20140614', '1万', '1', '100', 1, '32', '12345678', '全面介绍了Android应用开发的各种技术，主要内容包括Android的四大应用程序组件(Activity、Service、Content Provider和Broadcast Receiver)、布局、菜单、控件、资源和本地化、可视化UI设计、对话框、Toast和通知栏(Notification)、Fragment、ActionBar、拖放技术、数据存储技术、Android支持的各种组件技术、通信技术(蓝牙、NFC、网络等)、异步装载、推送技术、多媒体、2D绘图技术、OpenGL ES、桌面小部件、动态壁纸、短信和彩信、传感器、GPS、谷歌地图、人机交互、输入法开发、Android NDK开发、测试驱动开发、性能优化等。', '这真是一本好书啊'),
	(25, '谢希仁　编著', '电子工业出版社', '20140614', '694000', '1', '445', 1, '32', 'ISBN9787121201677', '该书自出版以来，受到国内各大专院校师生的好评，被国内著名高校如清华大学、北京邮电大学、成都电子科技大学、西安电子科技大学等100多所院校选为教材，特别是计算机网络专业、通信与信息化专业、电子工程专业使用本教材的比较多；有些相关专业也指定本教材为计算机网络方面的参考书，供学生深入掌握网络知识。', '这真是一本好书啊'),
	(26, '谭浩强', '\r\n\r\n清华大学出版社', '20140614', '694000', '1', '445', 1, '32', '12345678', '由谭浩强教授著、清华大学出版社出版的《C程序设计》是一本公认的学习C语言程序设计的经典教材。', '这真是一本好书啊'),
	(27, '王秋芬　等编著', '清华大学出版社', '20140614', '694000', '1', '445', 1, '32', '12345678', ' 王秋芬、吕聪颖、周春光编著的《算法设计与分析》侧重于算法步骤的设计及实例构造，注重算法与数据结构的结合、算法时间效率分析。其特色在于针对每一种算法设计策略，按照算法思想设计了详细的算法步骤，构造了具体实例以展现算法的详细演示过程，最后给出算法描述。本书内容精练，算法设计步骤清晰，实例构造详尽，算法描述的注释清楚，阅读材料丰富，易教、易学。', '这真是一本好书啊'),
	(28, '雷震甲，吴晓葵，严体华　编著', '清华大学出版社', '20140614', '694000', '1', '445', 1, '32', '12345678', '全国计算机技术与软件专业技术资格考试指定用书。本教材根据第三版的内容，并根据考试的重点内容做了较大篇幅的修订，书中主要内容包括：数据通信、广域通信网、局域网、城域网、因特网、网络安全、网络操作系统与应用服务器配置、组网技术、网络管理和网络规划和设计。', '这真是一本好书啊'),
	(29, '\r\n\r\n[美]Todd Lammle 著', '人民邮电出版社', '20140614', '694000', '1', '445', 1, '32', '12345678', '《CCNA学习指南(640-802)(第7版)》通过大量示例、动手实验、书面试验、真实场景分析，全面介绍了联网和TCP/IP等的背景知识、子网划分、VLSM、思科IOS、命令行界面、路由和交换、VLAN、安全和访问列表、网络地址转换、无线技术、IPv6以及WAN等内容。本书光盘带有SYBEX测试引擎，包含各章的复习题、全面的模拟考试、电子抽认卡、CCNA模拟考试指南(Todd Lammle的全新视频、音频指导)及PDF电子书。　　《CCNA学习指南(640-802)(第7版)》适合所有CCNA应试人员、网络管理人员及开发人员学习参考。 ', '这真是一本好书啊'),
	(30, '郭春柱　等编著', '机械工业出版社', '20140614', '694000', '1', '445', 1, '32', '12345678', '本书语言通俗易懂，内容丰富翔实，可以帮助读者用最少的时间，掌握更多知识及经验技巧，难度适中但非常实用，是广大有志于通过信息系统项目管理师考试的考生考前复习用的应试辅导用书，也可供各类高等院校（或培训班）的老师作为教学参考用书，各类计算机、软件工程、信息管理等专业的学生，以及从事信息化工作的项目实施人员和管理人员，也可从本书中获取信息系统项目管理方面的理论知识及实践经验。 ', '这真是一本好书啊');
/*!40000 ALTER TABLE `d_book` ENABLE KEYS */;


-- 导出  表 dangdb.d_category 结构
CREATE TABLE IF NOT EXISTS `d_category` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `turn` int(10) NOT NULL,
  `en_name` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `parent_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- 正在导出表  dangdb.d_category 的数据：~13 rows (大约)
/*!40000 ALTER TABLE `d_category` DISABLE KEYS */;
REPLACE INTO `d_category` (`id`, `turn`, `en_name`, `name`, `description`, `parent_id`) VALUES
	(1, 1, 'Book', '图书', NULL, 0),
	(2, 2, 'Foreign Language', '英语', NULL, 1),
	(3, 3, 'Computer', '计算机', NULL, 1),
	(4, 1, 'Englishtest', '英语考试', NULL, 2),
	(5, 2, 'Novel', '英语小说', NULL, 2),
	(6, 3, 'Tools', '工具书', NULL, 2),
	(7, 4, 'CollegeEnglish', '大学英语', NULL, 2),
	(8, 5, 'Tongue', '口语', NULL, 2),
	(9, 1, 'Computer Theory', '计算机理论', NULL, 3),
	(10, 2, 'Database', '数据库', NULL, 3),
	(11, 3, 'Programming', '程序设计', NULL, 3),
	(12, 4, 'CollegeBooks', '大学教材', NULL, 3),
	(13, 5, 'Computer Examination', '计算机考试', NULL, 3);
/*!40000 ALTER TABLE `d_category` ENABLE KEYS */;


-- 导出  表 dangdb.d_category_product 结构
CREATE TABLE IF NOT EXISTS `d_category_product` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `product_id` int(10) NOT NULL,
  `cat_id` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;

-- 正在导出表  dangdb.d_category_product 的数据：~90 rows (大约)
/*!40000 ALTER TABLE `d_category_product` DISABLE KEYS */;
REPLACE INTO `d_category_product` (`id`, `product_id`, `cat_id`) VALUES
	(1, 1, 1),
	(2, 2, 1),
	(3, 3, 1),
	(4, 4, 1),
	(5, 5, 1),
	(6, 6, 1),
	(7, 7, 1),
	(8, 8, 1),
	(9, 9, 1),
	(10, 10, 1),
	(11, 11, 1),
	(12, 12, 1),
	(13, 13, 1),
	(14, 14, 1),
	(15, 15, 1),
	(16, 16, 1),
	(17, 17, 1),
	(18, 18, 1),
	(19, 19, 1),
	(20, 20, 1),
	(21, 21, 1),
	(22, 22, 1),
	(23, 23, 1),
	(24, 24, 1),
	(25, 25, 1),
	(26, 26, 1),
	(27, 27, 1),
	(28, 28, 1),
	(29, 29, 1),
	(30, 30, 1),
	(31, 1, 2),
	(32, 2, 2),
	(33, 3, 2),
	(34, 4, 2),
	(35, 5, 2),
	(36, 6, 2),
	(37, 7, 2),
	(38, 8, 2),
	(39, 9, 2),
	(40, 10, 2),
	(41, 11, 2),
	(42, 12, 2),
	(43, 13, 2),
	(44, 14, 2),
	(45, 15, 2),
	(46, 16, 3),
	(47, 17, 3),
	(48, 18, 3),
	(49, 19, 3),
	(50, 20, 3),
	(51, 21, 3),
	(52, 22, 3),
	(53, 23, 3),
	(54, 24, 3),
	(55, 25, 3),
	(56, 26, 3),
	(57, 27, 3),
	(58, 28, 3),
	(59, 29, 3),
	(60, 30, 3),
	(61, 1, 4),
	(62, 2, 4),
	(63, 3, 4),
	(64, 4, 5),
	(65, 5, 5),
	(66, 6, 5),
	(67, 7, 6),
	(68, 8, 6),
	(69, 9, 6),
	(70, 10, 7),
	(71, 11, 7),
	(72, 12, 7),
	(73, 13, 8),
	(74, 14, 8),
	(75, 15, 8),
	(76, 16, 9),
	(77, 17, 9),
	(78, 18, 9),
	(79, 19, 10),
	(80, 20, 10),
	(81, 21, 10),
	(82, 22, 11),
	(83, 23, 11),
	(84, 24, 11),
	(85, 25, 12),
	(86, 26, 12),
	(87, 27, 12),
	(88, 28, 13),
	(89, 29, 13),
	(90, 30, 13);
/*!40000 ALTER TABLE `d_category_product` ENABLE KEYS */;


-- 导出  表 dangdb.d_order 结构
CREATE TABLE IF NOT EXISTS `d_order` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `status` int(10) NOT NULL,
  `order_time` bigint(20) NOT NULL,
  `order_desc` varchar(100) DEFAULT NULL,
  `total_price` double NOT NULL,
  `receive_name` varchar(100) DEFAULT NULL,
  `full_address` varchar(200) DEFAULT NULL,
  `postal_code` varchar(8) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 正在导出表  dangdb.d_order 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `d_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `d_order` ENABLE KEYS */;


-- 导出  表 dangdb.d_product 结构
CREATE TABLE IF NOT EXISTS `d_product` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(100) NOT NULL,
  `description` varchar(150) DEFAULT NULL,
  `add_time` bigint(20) DEFAULT NULL,
  `fixed_price` double NOT NULL,
  `dang_price` double NOT NULL,
  `keywords` varchar(200) DEFAULT NULL,
  `has_deleted` int(1) NOT NULL DEFAULT '0',
  `product_pic` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- 正在导出表  dangdb.d_product 的数据：~30 rows (大约)
/*!40000 ALTER TABLE `d_product` DISABLE KEYS */;
REPLACE INTO `d_product` (`id`, `product_name`, `description`, `add_time`, `fixed_price`, `dang_price`, `keywords`, `has_deleted`, `product_pic`) VALUES
	(1, '四级词汇词根+联想记忆法', '本书配备了诙谐幽默的漫画插图和实考真题，帮助考生在轻松的氛围中和真实的语境中掌握词汇。', 20140614, 32, 21, 'key', 0, '1.jpg'),
	(2, 'GRE词汇精选', '自出版以来即受广大考生的爱戴与推崇，十几年来已帮助数十万考生取得高分，顺利出国留学。', 20140614, 58, 40, 'key', 0, '2.jpg'),
	(3, '思思大王讲单词 :四级单词一笑而过 ', '中国最红的英语老师，单词最潮的学习方法，四级考试就这样一笑而过！', 20140614, 38, 27, 'key', 0, '3.jpg'),
	(4, 'The Kite Runner (追风筝的人)', '是一个阿富汗作家的处女作，霸占了美国两大权威畅销书排行榜《纽约时报》排行榜、《出版商周刊》排行榜长达80余周.', 20140614, 58, 30, 'key', 0, '4.jpg'),
	(5, 'One Day 一天', 'Emma Morley and Dexter Mayhew, casual acquaintances duringtheir university years...', 20140614, 108, 51, 'key', 0, '5.jpg'),
	(6, 'TwelveYears a Slave(为奴十二年) 第86届奥斯卡最佳影片', '讲述的是自由黑人所罗门生活在纽约市，但是在1841年被人以拉小提琴为名，设计绑架，被卖到了南方的种植园。\r\n', 20140614, 105, 60, 'key', 0, '6.jpg'),
	(7, '牛津高阶英汉双解词典', '牛津高阶为世所公认的权威英语学习词典，创同类词典之先河。自1948年出版至今，累计发行量逾3000万册，广受全球读者欢迎。', 20140614, 118, 89, 'key', 0, '7.jpg'),
	(8, '朗文当代英语大辞典(英英·英汉双解) 新版 ', '《朗文当代英语大辞典》的“大"在于其文化知识的广泛涉猎，犹如展开一部百科全书。', 20140614, 138, 117, 'key', 0, '8.jpg'),
	(9, '剑桥高阶英汉双解词典', '凝聚着剑桥创新精神的一部高端精品，外语教学与研究出版社推出的是它的双解版。', 20140614, 108, 95, 'key', 0, '9.jpg'),
	(10, '全新版大学英语综合教程课文辅导大全4', '本书对每篇课文中出现的长难句进行框架剖析，指点长难句的破解方法，培养您对长难句的感知、分析能力，提高翻译水平。', 20140614, 16, 13, 'key', 0, '10.jpg'),
	(11, '大学英文写作', '该书是“高等学校英语专业规划教材”之一，该书以满期足英语专业本科阶段不同年级写作教学上的需要所编写的，其重点是议论文写作，', 20140614, 34, 28, 'key', 0, '11.jpg'),
	(12, '薄冰大学英语语法 ', '本书主要特点是对语法讲解系统、全面，知识体系完备，对每一个语法点都尽可能讲得细致、透彻，以满足大学生日常学习语法。', 20140614, 45, 27, 'key', 0, '12.jpg'),
	(13, '商务英语口语王', '生动诠释“立竿见影”，700个高频商务话题，迅速提升你的职场含金量。', 20140614, 33, 20, 'key', 0, '13.jpg'),
	(14, '软件设计师软考辅导·3年真题精解与闯关密卷 ', '从字母、音标开始讲起．不限定学习人群，是一本全面的英语启蒙教材。', 20140614, 59, 47, 'key', 0, '14.jpg'),
	(15, '生活英语情景口语100主题', '本书越过了“生存口语”的层次，深入到社会生活的细微之处。与同类型的书相比，拥有更广泛的话题、更生动的表达、更浓厚趣味。', 20140614, 38, 31, 'key', 0, '15.jpg'),
	(16, '信息简史', '书中细致还原了历史细节，通俗解释了各种理论，还生动刻画了几位不为大众所熟知的人物。', 20140614, 69, 48, 'key', 0, '16.jpg'),
	(17, '算法心得：高效算法的奥秘', '在本书中，作者给我们带来了一大批极为诱人的知识，其中包括各种节省程序运行时间的技巧、算法与窍门。', 20140614, 89, 63, 'key', 0, '17.jpg'),
	(18, '计算机组成与设计：硬件、软件接口', '全书着眼于当前计算机设计中最基本的概念，展示了软硬件间的关系，并全面介绍当代计算机系统发展的主流技术和最新成就。', 20140614, 99, 79, 'key', 0, '18.jpg'),
	(19, '数据库系统概念', '全面介绍数据库系统的各种知识，透彻阐释数据库管理的基本概念。', 20140614, 73, 67, 'key', 0, '19.jpg'),
	(20, 'Oracle从入门到精通', '本书不仅是一本Oracle 11g的入门教材也是初学者快速掌握Oracle 11g的捷径。', 20140614, 58, 44, 'key', 0, '20.jpg'),
	(21, 'MySQL入门经典', '本书适用于MySQL的爱好者、初学者和中级开发人员，也可以作为大中专院校和培训机构的教材。', 20140614, 69, 53, 'key', 0, '21.jpg'),
	(22, 'Objective-C编程', '本书讲述Objective-C编程语言和基本的iOS/Mac开发知识。', 20140614, 58, 46, 'key\r\n\r\n', 0, '22.jpg'),
	(23, 'C语言从入门到精通', '从初学者的角度出发，通过通俗易懂的语言，丰富多彩的实例.', 20140614, 69, 56, 'key', 0, '23.jpg'),
	(24, 'Android开发权威指南', '是一本全面介绍Android应用开发的专著，拥有45章精彩内容供读者学习。', 20140614, 99, 83, 'key', 0, '24.jpg'),
	(25, 'Android开发权威指南', '该书自出版以来，受到国内各大专院校师生的好评。', 20140614, 39, 30, 'key', 0, '25.jpg'),
	(26, 'C程序设计', '由谭浩强教授著的《C程序设计》是一本公认的学习C语言程序设计的经典教材。', 20140614, 35, 25, 'key', 0, '26.jpg'),
	(27, '算法设计与分析', '侧重于算法步骤的设计及实例构造，注重算法与数据结构的结合、算法时间效率分析。', 20140614, 35, 26, 'key', 0, '27.jpg'),
	(28, '网络工程师教程（第三版）', '全国计算机技术与软件专业技术资格。水平考试指定用书', 20140614, 69, 55, 'key', 0, '28.jpg'),
	(29, 'CCNA学习指南（640-802）', 'CCNA考试640-802的权威指南，由思科技术知名权威针对最新考试目标编写，旨在帮助考生全面掌握考试内容。', 20140614, 99, 74, 'key', 0, '29.jpg'),
	(30, '算法设计与分析', '侧重于算法步骤的设计及实例构造，注重算法与数据结构的结合、算法时间效率分析。', 20140614, 35, 26, 'key', 0, '30.jpg');
/*!40000 ALTER TABLE `d_product` ENABLE KEYS */;


-- 导出  表 dangdb.d_receive_address 结构
CREATE TABLE IF NOT EXISTS `d_receive_address` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `receive_name` varchar(20) NOT NULL,
  `full_address` varchar(200) NOT NULL,
  `postal_code` varchar(8) NOT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- 正在导出表  dangdb.d_receive_address 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `d_receive_address` DISABLE KEYS */;
REPLACE INTO `d_receive_address` (`id`, `user_id`, `receive_name`, `full_address`, `postal_code`, `mobile`, `phone`) VALUES
	(1, 6, 'Java', 'sun.cn', '10000800', '12345', '67890'),
	(2, 6, 'JavaJavaJava', 'ibm.cn', '10000600', '12345', '67890');
/*!40000 ALTER TABLE `d_receive_address` ENABLE KEYS */;


-- 导出  表 dangdb.d_user 结构
CREATE TABLE IF NOT EXISTS `d_user` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `nickname` varchar(50) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  `is_email_verify` char(3) DEFAULT NULL,
  `email_verify_code` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- 正在导出表  dangdb.d_user 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `d_user` DISABLE KEYS */;
REPLACE INTO `d_user` (`id`, `email`, `nickname`, `password`, `is_email_verify`, `email_verify_code`) VALUES
	(1, '1028811369@qq.com', '天从俩人', 'ICy5YqxZB1uWSwcVLSNLcA==', NULL, NULL),
	(12, '123', '123', 'ICy5YqxZB1uWSwcVLSNLcA==', NULL, NULL),
	(13, '10288', '123', 'ICy5YqxZB1uWSwcVLSNLcA==', NULL, NULL),
	(18, 'htc1991@sina.com', 'HTC', 'ICy5YqxZB1uWSwcVLSNLcA==', 'N', NULL);
/*!40000 ALTER TABLE `d_user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
