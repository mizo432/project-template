create table admin.glossary_item
(
    glossary_item_id BIGINT,
    word             varchar(128)  NOT NULL,
    kana_word        varchar(128)  NOT NULL,
    description      varchar(1024) NOT NULL,
    primary key (glossary_item_id)
);

comment on table admin.glossary_item IS '用語辞書アイテム';
comment on column admin.glossary_item.glossary_item_id IS '用語集アイテムID';
comment on column admin.glossary_item.word IS '用語';
comment on column admin.glossary_item.kana_word IS '用語読み';
comment on column admin.glossary_item.description IS '詳細';
