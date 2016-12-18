/*   min ta bgalete apo ta sxolia... einai mia dokimi gia to pos 8a mporousame na kanouem to save


package com.Game.Game;



import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.snapshot; // de litourgei auti h class


import java.math.BigInteger;
import java.util.Random;

import static android.content.ContentValues.TAG;

public class SaveLoadExample1 {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Create the Google API Client with access to Plus, Games, and Drive
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(Games.API).addScope(Games.SCOPE_GAMES)
                .addApi(Drive.API).addScope(Drive.SCOPE_APPFOLDER)
                .build();
    }

        private static final int RC_SAVED_GAMES = 9009;

    private void showSavedGamesUI() {
        int maxNumberOfSavedGamesToShow = 5;
        Intent savedGamesIntent = Games.Snapshots.getSelectSnapshotIntent(mGoogleApiClient,
                "See My Saves", true, true, maxNumberOfSavedGamesToShow);
        startActivityForResult(savedGamesIntent, RC_SAVED_GAMES);
    }


    private String mCurrentSaveName = "snapshotTemp";

    /**
     * This callback will be triggered after you call startActivityForResult from the
     * showSavedGamesUI method.
     */
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent intent) {
        if (intent != null) {
            if (intent.hasExtra(Snapshots.EXTRA_SNAPSHOT_METADATA)) {
                // Load a snapshot.
                SnapshotMetadata snapshotMetadata = (SnapshotMetadata)
                        intent.getParcelableExtra(Snapshots.EXTRA_SNAPSHOT_METADATA);
                mCurrentSaveName = snapshotMetadata.getUniqueName();

                // Load the game data from the Snapshot
                // ...
            } else if (intent.hasExtra(Snapshots.EXTRA_SNAPSHOT_NEW)) {
                // Create a new snapshot named with a unique string
                String unique = new BigInteger(281, new Random()).toString(13);
                mCurrentSaveName = "snapshotTemp-" + unique;

                // Create the new snapshot
                // ...
            }
        }
    }

    private PendingResult<Snapshots.CommitSnapshotResult> writeSnapshot(Snapshot snapshot,
                                                                        byte[] data, Bitmap coverImage, String desc) {

        // Set the data payload for the snapshot
        snapshot.getSnapshotContents().writeBytes(data);

        // Create the change operation
        SnapshotMetadataChange metadataChange = new SnapshotMetadataChange.Builder()
                .setCoverImage(coverImage)
                .setDescription(desc)
                .build();

        // Commit the operation
        return Games.Snapshots.commitAndClose(mGoogleApiClient, snapshot, metadataChange);
    }


    //LOAD------------

    private static final int MAX_SNAPSHOT_RESOLVE_RETRIES = 3;

    /**
     * Conflict resolution for when Snapshots are opened.  Must be run in an AsyncTask or in a
     * background thread,
     */
/*
    Snapshot processSnapshotOpenResult(Snapshots.OpenSnapshotResult result, int retryCount) {
        Snapshot mResolvedSnapshot = null;
        retryCount++;

        int status = result.getStatus().getStatusCode();
        Log.i(TAG, "Save Result status: " + status);

        if (status == GamesStatusCodes.STATUS_OK) {
            return result.getSnapshot();
        } else if (status == GamesStatusCodes.STATUS_SNAPSHOT_CONTENTS_UNAVAILABLE) {
            return result.getSnapshot();
        } else if (status == GamesStatusCodes.STATUS_SNAPSHOT_CONFLICT) {
            Snapshot snapshot = result.getSnapshot();
            Snapshot conflictSnapshot = result.getConflictingSnapshot();

            // Resolve between conflicts by selecting the newest of the conflicting snapshots.
            mResolvedSnapshot = snapshot;

            if (snapshot.getMetadata().getLastModifiedTimestamp() <
                    conflictSnapshot.getMetadata().getLastModifiedTimestamp()) {
                mResolvedSnapshot = conflictSnapshot;
            }

            Snapshots.OpenSnapshotResult resolveResult = Games.Snapshots.resolveConflict(
                    mGoogleApiClient, result.getConflictId(), mResolvedSnapshot).await();

            if (retryCount < MAX_SNAPSHOT_RESOLVE_RETRIES) {
                // Recursively attempt again
                return processSnapshotOpenResult(resolveResult, retryCount);
            } else {
                // Failed, log error and show Toast to the user
                String message = "Could not resolve snapshot conflicts";
                Log.e(TAG, message);
                Toast.makeText(getBaseContext(), message, Toast.LENGTH_LONG).show();
            }

        }

        // Fail, return null.
        return null;
    }

}

