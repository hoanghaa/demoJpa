class EditUserManager {
    constructor() {
        this.userId = null;
    }

    async loadInit() {
        await this.fetchProduct();
        this.fillFormData();
    }

    async fetchProduct() {
        const urlParams = new URLSearchParams(window.location.search);
        this.userId = urlParams.get('id');
        console.log(this.userId);

        try {
            const response = await axios.get(`/api/user-api/getUserByUserId?userId=${this.userId}`);
            if (response.data.success) {
                this.userData = response.data.data;
                // this.fillFormData(response.data)
            } else {
                console.error('Lấy thông tin sản phẩm không thành công:', response.data.message);
            }
        } catch (error) {
            console.error('Lỗi khi lấy thông tin sản phẩm:', error);
        }
    }
    fillFormData() {
        $('#userId').val(this.userData.userId);
        $('#username').val(this.userData.userName);
        $('#password').val(this.userData.password);
        $('#fullName').val(this.userData.fullName);
        $('#address').val(this.userData.address);
        $('#age').val(this.userData.age);
        $('#roleId').val(this.userData.roleId);
        // $('#role').prop('checked', true);
    }

    async btn_Luu_click (){
        let dataApiUser = {
            userId: $('#userId').val(),
            userName: $('#username').val(),
            password: $('#password').val(),
            fullName: $('#fullName').val(),
            address: $('#address').val(),
            age: $('#age').val()
        }
        let response = await axios.post('/api/user-api/saveUser', dataApiUser);
        if(!response.data.success) {
            alert("Lỗi khi lưu dữ liệu. Vui lòng thử lại");
        }
        alert("Đã cập nhật thành công");
    }

    async loadRoles() {
        try {
            const response = await axios.get('/role_api/getAllRole');
            if (response.data.success) {
                const roles = response.data.data;
                const roleDiv = $('#role');
                roles.forEach(role => {
                    const radioBtn = $('<input type="radio" class="form-check-input" name="role" value="' + role.roleId + '">');
                    const label = $('<label class="form-check-label">' + role.roleName + '</label>');
                    const div = $('<div class="form-check">');
                    div.append(radioBtn);
                    div.append(label);
                    roleDiv.append(div);
                });
            } else {
                console.error('Lỗi: ', response.data.message);
            }
        } catch (error) {
            console.error('Lỗi khi gọi API: ', error);
        }
    }


}
