class UserManager {
    constructor() {
        this.users = [];
    }

    async loadInit() {
        await this.fetchUsers();
        this.createTableProducts();
    }

    async fetchUsers() {
        try {
            const response = await axios.get('/api/user-api/getAllUser');
            if (response.data.success) {
                this.users = response.data.data;
            } else {
                console.error('Lỗi: ', response.data.message);
            }
        } catch (error) {
            console.error('Lỗi khi gọi API: ', error);
        }
    }

    createTableProducts() {
        const userRow = $('#userRow');
        this.users.forEach((user, index) => {
            if (index % 4 === 0) {
                userRow.append('<div class="row mb-4"></div>');
            }
            const card = $('<div class="col-md-3">' +
                '<div class="card">' +
                '<div class="card-body">' +
                `<h5 class="card-title">Tên đăng nhập: ${user.userName}</h5>` +
                `<p class="card-text">Mật khẩu: ${user.password}</p>` +
                `<p class="card-text">Họ tên: ${user.fullName}</p>` +
                `<p class="card-text">Tuổi: ${user.age}</p>` +
                `<button class="btn btn-primary me-3 order-button" data-id="${user.userId}">Đặt hàng</button>` +
                `<button class="btn btn-secondary edit-button" data-id="${user.userId}">Chỉnh sửa</button>` +
                '</div>' +
                '</div>' +
                '</div>');
            userRow.find('.row').last().append(card);
        });

        $('.order-button').click(function() {
            const userId = $(this).data('id');
            alert('Đã đặt hàng sản phẩm có ID ' + userId + '!');
        });

        $('.edit-button').click(function() {
            const userId = $(this).data('id');
            window.location.href = `/users/id?id=${userId}`;
        });
    }
}
