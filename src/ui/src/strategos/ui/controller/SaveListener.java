package strategos.ui.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SaveListener extends Controller implements ActionListener {

    private Controller controller;

    SaveListener(Controller controller) {
        super(controller);
        this.controller = controller;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.save();
        view.removeEscapeMenu();
        controller.menuToggle();
    }
}
