Ext.define('cam3tshop.view.Login', {
    extend: 'Ext.form.Panel',
    alias: "widget.loginview",
    requires: ['Ext.form.FieldSet', 'Ext.form.Password', 'Ext.Label', 'Ext.Img'],
    config: {
        title: 'Login',
        scrollable: null,

        items: [{
            xtype: 'image',
            src: 'logo_bootshop.png',
            style: 'height:100px;margin:auto;margin-top: 30%;'
        }, {
            xtype: 'label',
            html: 'Login failed. Please enter the correct credentials.',
            itemId: 'signInFailedLabel',
            hidden: true,
            hideAnimation: 'fadeOut',
            showAnimation: 'fadeIn',
            style: 'color:#990000;margin:5px 0px;'
        }, {
            xtype: 'fieldset',
            title: 'Login Example',
            style: 'margin-right:20px;margin-left:20px;',
            items: [{
                id: 'txb_login_email',
                xtype: 'textfield',
                placeHolder: 'Email',
                itemId: 'userNameTextField',
                name: 'userNameTextField',                
                required: true
            }, {
                id: 'txb_login_pass',
                xtype: 'passwordfield',
                placeHolder: 'Password',
                itemId: 'passwordTextField',
                name: 'passwordTextField',
                required: true
            }]
        }, {
            xtype: 'button',
            itemId: 'logInButton',
            id: 'btn_login',
            ui: 'action',
            padding: '10px',
            style: 'margin-right:20px;margin-left:20px;',
            text: 'Log In'
        }]
    }
});
