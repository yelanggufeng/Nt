package com.netintech.process.controller;

import org.activiti.engine.ActivitiException;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;

/**
 * @author admin
 */
@RequestMapping("/modeler")
@RestController
public class StencilsetRestResource {


  /**
   * 加载汉化json
   * @return
   */
  @GetMapping(value="/editor/stencilset", produces = "application/json;charset=utf-8")
  public @ResponseBody
  String getStencilset() {
    InputStream stencilsetStream = this.getClass().getClassLoader().getResourceAsStream("stencilset.json");
    try {
      return IOUtils.toString(stencilsetStream, "utf-8");
    } catch (Exception e) {
      throw new ActivitiException("Error while loading stencil set", e);
    }
  }

}
