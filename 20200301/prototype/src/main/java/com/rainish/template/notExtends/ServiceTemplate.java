package com.rainish.template.notExtends;

public class ServiceTemplate {
    private TestService testService;

    public ServiceTemplate(TestService testService) {
        this.testService = testService;
    }

    public void saveOrUpdate(Long id){
        if(id == null){
            this.save();
        }else
            this.update();
        testService.afterSaveOrUpdate();
    }

    private void update() {
    }

    private void save() {
        System.out.println("模板先保存数据");
    }

}
