package com.office.controller;

import com.office.entity.Position;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/positions")


public class PositionController extends AController<Position> { }

