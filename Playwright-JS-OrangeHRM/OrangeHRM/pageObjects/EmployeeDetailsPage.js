import { expect } from "@playwright/test";

exports.EmployeeDetailsPage = class EmployeeDetailsPage {
    constructor(page){
        this.page = page;
        //Locators
        this.txt_lastName_xpath = page.locator("//input[@placeholder='Last Name']");
        this.rd_gender_xpath = page.locator("//label[normalize-space()='Male']");
        this.btn_save_xpath = page.locator("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[@type='submit']");
        this.toast_success_xpath = page.locator("//p[@class='oxd-text oxd-text--p oxd-text--toast-title oxd-toast-content-text']");
    }

    async updateEmployeeDetails(){
        await this.rd_gender_xpath.click();
    }
    async clickSave(){
        await this.btn_save_xpath.click();
    }
    async checkSuccessToast(){
        await expect.soft(this.toast_success_xpath).toHaveText('Success');
    }

}
