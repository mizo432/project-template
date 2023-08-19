CREATE TABLE admin.holiday
(
    holidayId BIGINT,
    holiday   DATE         NOT NULL,
    name      VARCHAR(100) NOT NULL,
    primary key (holidayId)
);

comment on table admin.holiday is '祝日';
COMMENT ON COLUMN admin.holiday.holidayId IS '祝日ID';
COMMENT ON COLUMN admin.holiday.holiday IS '祝日';
COMMENT ON COLUMN admin.holiday.name IS '祝日名称';
