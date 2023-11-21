use pasteboard;
# 创建一个用户表，中包含字段 主键id自增，用户名，密码，邮箱，创建时间，更新时间，是否删除
drop table if exists user;
create table user
(
    id          int primary key auto_increment,
    username    varchar(20) unique not null,
    password    varchar(20),
    email       varchar(50),
    create_time datetime default now(),
    update_time datetime default now() on update now(),
    delete_flag   bit      default 0
);

# 创建一个文档表，中包含字段 主键id自增，用户id，文档标题，文档内容，创建时间，更新时间，是否删除
drop table if exists doc;
create table doc
(
    id          int primary key auto_increment,
    user_id     int         not null,
    title       varchar(50) not null,
    content     text,
    create_time datetime default now(),
    update_time datetime default now() on update now(),
    delete_flag   bit      default 0
);
