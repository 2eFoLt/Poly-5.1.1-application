from flask import Flask, render_template, request, session, redirect, url_for
from werkzeug.security import generate_password_hash
import random
# check_password_hash

app = Flask(__name__)
app._static_folder = "static"
app.secret_key = generate_password_hash("IWasHere")


@app.route('/', methods=['GET', 'POST'])
def index():
    return render_template('newStartPage.html')


@app.route('/checkout', methods=['GET'])
def checkout():
    return render_template('newCheckoutPage.html')


@app.route('/login')
def login():
    if 'email' in session:
        return redirect(url_for('main'))
    return render_template('newLoginPage.html')


@app.route('/main')
def main():
    if 'email' in session:
        return render_template('newMainPage.html', login=session['email'])
    else:
        redirect(url_for('login'))


@app.route('/logout')
def logout():
    session.pop('email', None)
    session.pop('hash', None)
    session.pop('id', None)
    return redirect(url_for('index'))


@app.route('/log-success', methods=['POST'])
def success():
    if request.method == 'POST':
        email = request.form['email']
        passwd = request.form['password']
        userid = random.randint(1, 1000)
        if email not in session:
            session['email'] = email
            session['hash'] = generate_password_hash(passwd)
            session['id'] = userid
        return redirect(url_for('main'))
    else:
        pass


"""
Route template:
@app.route(<html-route>, <methods>)
def <html-name>():
    return render_template('html-file')
"""
if __name__ == '__main__':
    app.run(
         # host='0.0.0.0', port=5151
    )
