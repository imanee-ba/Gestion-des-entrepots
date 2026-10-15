CREATE TABLE warehouses(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(30) NOT NULL UNIQUE,
    name VARCHAR(150) NOT NULL,
    address VARCHAR(255),
    active BOOLEAN NOT NULL DEFAULT TRUE
);
CREATE TABLE locations(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    warehouses_id BIGINT NOT NULL,
    zone_code VARCHAR(30) NOT NULL,
    aisle_code VARCHAR(30) NOT NULL,
    rack_code VARCHAR(30) NOT NULL,
    level_code VARCHAR(30) NOT NULL,
    position_code VARCHAR(30) NOT NULL,
    full_address VARCHAR(30) NOT NULL,
    capacity INT NOT NULL,
    occupied NOT NULL DEFAULT 0,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    blocked BOOLEAN NOT NULL DEFAULT FALSE,
    qr_token VARCHAR(36) NOT NULL UNIQUE,
    CONSTRAINT fk_location_warehouse FOREIGN KEY(warehouse_id) REFERENCES warehouses(id),
    CONSTRAINT ck_location_capacity CHECK (capacity > 0 AND occupied >=0 AND occupied <= capacity)
);
CREATE INDEX idx_location_parent ON location (warehouse_id,zone_code,aisle_code,rack_code,level_code);