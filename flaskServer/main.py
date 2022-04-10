from flask import Flask, render_template, request

app = Flask(__name__)
app._static_folder = "static"


@app.route('/', methods=['GET', 'POST'])
def index():
    return render_template('newMainPage.html')


@app.route('/login')
def login():
    return render_template('newLoginPage.html')


@app.route('/log-success', methods=['POST'])
def success():
    if request.method == 'POST':
        log = request.form['email']
        passwd = request.form['password']
        return render_template('success.html', login=log, password=passwd)
    else:
        pass


"""
Route template:
@app.route(<html-route>, <methods>)
def <html-name>():
    return render_template('<html-file')
"""
if __name__ == '__main__':
    app.run(
        # host='0.0.0.0', port=5151
    )
