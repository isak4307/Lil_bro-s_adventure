package inf112.lilBro.app.utils;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ContactListeners implements ContactListener {
    private final List<ContactListener> contactListeners;

    public ContactListeners() {
        contactListeners = new CopyOnWriteArrayList<>();
    }

    /**
     * Adds a {@link ContactListener} to receive contacts.
     *
     * @param contactListener to be added
     * @return if the collection of {@link ContactListener} changed
     */
    public boolean add(ContactListener contactListener) {
        return contactListeners.add(contactListener);
    }

    @Override
    public void beginContact(Contact contact) {
        for (ContactListener contactL : contactListeners) {
            contactL.beginContact(contact);
        }
    }

    @Override
    public void endContact(Contact contact) {
        for (ContactListener contactL : contactListeners) {
            contactL.endContact(contact);
        }

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
        for (ContactListener contactL : contactListeners) {
            contactL.preSolve(contact, oldManifold);
        }

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
        for (ContactListener contactL : contactListeners) {
            contactL.postSolve(contact, impulse);
        }
    }
}
