package com.example.demo.factoryBean;

import com.sun.tools.jconsole.JConsolePlugin;

import javax.swing.*;
import java.util.Map;

/**
 * @author kaiguang.wang
 * @version 1.0
 * @date 2022/2/28 23:48
 */
public class Test1 extends JConsolePlugin {


    @Override
    public Map<String, JPanel> getTabs() {
        return null;
    }

    @Override
    public SwingWorker<?, ?> newSwingWorker() {
        return null;
    }
}
