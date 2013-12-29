Ext.define('cam3tshop.view.Login', {
    extend: 'Ext.form.Panel',
    alias: "widget.loginview",
    requires: ['Ext.form.FieldSet', 'Ext.form.Password', 'Ext.Label', 'Ext.Img'],
    config: {
        title: 'Login',
        items: [{
        //     xtype: 'image',
        //     src: Ext.Viewport.getOrientation() == 'portrait' ? '../../../img/login.png' : '../../../img/login-small.png',
        //     style: Ext.Viewport.getOrientation() == 'portrait' ? 'width:80px;height:80px;margin:auto' : 'width:40px;height:40px;margin:auto'
        // }, {
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
            text: 'Log In'
        }]
    }
});
