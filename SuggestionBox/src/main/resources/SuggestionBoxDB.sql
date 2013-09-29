--This schema file, I forgot to check-in, I created once again. So, please verify once again
create table sb_category
(
category   varchar(1000),
total_level Number,
level_min_apv_map varchar(4000),
primary key (category)
);

create table sb_description(
uuid varchar(150),
sg_id varchar(150),
user varchar(50),
updated_on date,
is_liked varchar(2),
is_public varchar(3),
description Clob,
file_uuid varchar(100),
file_name varchar(150),

primary key (uuid)
);

create table sb_main(
sg_id varchar(150),
title varchar(250),
category varchar(100),
created_on date,
owner varchar(50),
approve_status varchar(25),
approve_level number,

primary key (sg_id)
);

create table sb_upload_files(
uuid varchar(150),
attachment blob,

primary key (uuid)
);


create table sb_user_priv(
uuid varchar(150),
owner varchar(50),
category varchar(100),
level number,
roles varchar(1000),
roles_code number,

primary key (uuid)
);