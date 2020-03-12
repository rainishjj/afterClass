package com.rainish.template;

public abstract class ServiceTemplate {
    public void saveOrUpdate(Long id){
        if(id == null){
            this.save();
        }else
            this.update();
        this.afterSaveOrUpdate();
    }

    private void update() {
    }

    private void save() {
        System.out.println("模板先保存数据");
    }

    protected abstract void afterSaveOrUpdate();
}
