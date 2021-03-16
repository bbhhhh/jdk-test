package com.bhh.java.interfac;

/**
 * @Project: jdk-test
 * @Author : haihuab
 * @Date : 2021/2/25 16:13
 * @Description: TODO
 */
public interface RootInt {
    void root();
}

interface Root2Int {
    void root2();
}

interface ChildOfRootInt extends RootInt {
    void childOfRoot();
}

interface ChildOfRootAndRoot2Int extends RootInt, Root2Int {
    void childOfRootAndRoot2();
}

class ChildOfRootIntImpl implements ChildOfRootInt {
    @Override
    public void root() {

    }

    @Override
    public void childOfRoot() {

    }
}

class ChildOfRootAndRoot2IntImpl implements ChildOfRootAndRoot2Int {

    @Override
    public void root() {

    }

    @Override
    public void root2() {

    }

    @Override
    public void childOfRootAndRoot2() {

    }
}

class RootIntAndRoot2IntImpl implements RootInt, Root2Int {

    @Override
    public void root() {

    }

    @Override
    public void root2() {

    }
}