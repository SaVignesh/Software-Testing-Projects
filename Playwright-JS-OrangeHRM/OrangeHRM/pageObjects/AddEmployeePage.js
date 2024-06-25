import { expect } from "@playwright/test";

exports.AddEmployeePage = class AddEmployeePage {
    constructor(page){
        this.page = page;
        //Locators
        this.txt_firstName_xpath = page.locator("//input[@name='firstName']");
        this.txt_lastName_xpath = page.locator("//input[@name='lastName']");
        this.btn_save_xpath = page.locator("//button[@type='submit']")
        this.toast_success_xpath = page.locator("//p[@class='oxd-text oxd-text--p oxd-text--toast-title oxd-toast-content-text']")
    }

    async enterDetails(firstName, lastName){
        await this.txt_firstName_xpath.fill(firstName);
        await this.txt_lastName_xpath.fill(lastName);
    }

    async clickSave(){
        await this.btn_save_xpath.click();
    }

    async checkSuccessToast(){
        await expect.soft(this.toast_success_xpath).toHaveText('Success');
    }
}