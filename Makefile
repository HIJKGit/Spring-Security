#!/usr/bin/make -f
NAME := s3s6p
IMAGE := spring-security
VERSION := latest
mkfile_path := $(abspath $(lastword $(MAKEFILE_LIST)))
current_dir := $(notdir $(patsubst %/,%,$(dir $(mkfile_path))))
First_PORT :=5432
Last_PORT :=5432
.PHONY: all build rebuild shell run bash

# ------------------------------------------------------------------------------

all: build

# 建置 image
build:
	docker build -t=$(IMAGE):$(VERSION) .

# 不使用 cache 建置 image
rebuild:
	docker build -t=$(IMAGE):$(VERSION) --no-cache .

# 執行並使用 shell 進入 container
shell:
	docker run --name $(NAME) -it -p $(First_PORT):$(Last_PORT) $(IMAGE):$(VERSION) bash

# 執行 container
run:
	docker run --name $(NAME) -d -v $(current_dir):/var/lib/postgresql/data -p $(First_PORT):$(Last_PORT) $(IMAGE):$(VERSION)

bash:
	docker exec -it $(NAME) bash