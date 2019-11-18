# 一本糊涂账

## 数据库

一共 3 个表：

- 配置表信息 config
  - 用于保存每月预算和Mysql的安装路径( 用于备份还原用)
  - id：主键，每个表都有一个主键 类型是 int
    key_： 配置信息按照键值对的形式出现 ，类型是varchar(255)
    value：配置信息的值, 类型是 varchar(255)
- 消费分类表 category
  - 用于保存消费分类，比如餐饮，交通，住宿
  - id：主键，每个表都有一个主键 类型是 int
    name：分类的名称，类型是 varchar(255)
- 消费记录表 record
  - 用于存放每一笔的消费记录，并且会用到消费分类
  - id：主键，每个表都有一个主键 类型是 int
    spend：本次花费，类型是int
    cid：对应的消费分类表的中记录的id, 类型是int
    comment：备注，比如分类是娱乐，但是你希望记录更详细的内容，啪啪啪，那么就存放在这里。
    date：日期，本次记录发生的时间。

## 目录结构

- gui
  - frame
    - MainFrame，主窗体类：整个程序只有一个主 Frame
  - Panel：然后每一个功能模块都有一个 Panel
    -  SpendPanel 消费一览面板类
    -  RecordPanel 记一笔面板类
  - Listener：把所有的监听器，都做成独立的类，实现 ActionListener 接口
    -  ToolBarListener 工具条监听器类
    -  BackupListener 备份监听器类
  - Model：用于存放数据，在这个项目中会用到 TableModel 和 ComboBoxModel
    -  CategoryComboBoxModel 分类下拉框 Model 类
    -  CategoryTableModel 分类表格 Model 类 

