package com.example.profilescreenassnmnt.ui.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.profilescreenassnmnt.R
import com.example.profilescreenassnmnt.ui.domain.data.UserActions
import com.example.profilescreenassnmnt.ui.domain.data.UserData

@Composable
fun ProfileScreen(
    profileViewModel: ProfileViewModel,
    onAction: (UserActions) -> Unit
) {

    val state = profileViewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
        ) {

            ProfileTopBar(
                onBackClick = { onAction(UserActions.onBackClick) },
                onSupportClick = { onAction(UserActions.onSupportClick) }
            )

            Spacer(modifier = Modifier.height(24.dp))

            ProfileHeader(
                name = state.value.userName,
                memberSince = "member since Dec, 2020",
                onEditClick = { onAction(UserActions.onEditProfileClick) }
            )

            Spacer(modifier = Modifier.height(24.dp))

            ProfileActionItem(
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_directions_car_24),
                        contentDescription = null,
                    )
                },
                title = "get to know your vehicles, inside out",
                subtitle = "CRED garage",
                showArrow = true,
                onClick = { onAction(UserActions.onCREDGarageClick) }
            )

            Spacer(modifier = Modifier.height(8.dp))

            ProfileStatsItem(
                icon = {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        painter = painterResource(id = R.drawable.baseline_sports_score_24),
                        contentDescription = null,
                    )
                },
                title = "credit score",
                action = "REFRESH AVAILABLE",
                actionColor = MaterialTheme.colorScheme.tertiary,
                value = state.value.creditScore.toString(),
                onClicked = { onAction(UserActions.onCreditScoreClick) }
            )

            Divider(
                color = Color.DarkGray.copy(alpha = 0.5f)
            )

            ProfileStatsItem(
                icon = {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        painter = painterResource(id = R.drawable.baseline_attach_money_24),
                        contentDescription = null,
                    )
                },
                title = "lifetime cashback",
                value = "₹${state.value.cashback}",
                onClicked = { onAction(UserActions.onLifeTimeCashbackClick) }
            )

            Divider(
                color = Color.DarkGray.copy(alpha = 0.5f)
            )

            ProfileStatsItem(
                icon = {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        painter = painterResource(id = R.drawable.baseline_account_balance_24),
                        contentDescription = null,
                    )
                },
                title = "bank balance",
                value = "check",
                onClicked = { onAction(UserActions.onBankBalanceClick) }
            )

            Divider(
                color = Color.DarkGray.copy(alpha = 0.5f)
            )

            Spacer(modifier = Modifier.height(32.dp))

            SectionHeader(title = "YOUR REWARDS & BENEFITS")

//            Spacer(modifier = Modifier.height(16.dp))

            RewardsItem(
                title = "cashback balance",
                value = "₹${state.value.cashBankBalance}",
                onClick = { onAction(UserActions.onCashbackBalanceClick) }
            )

            Divider(
//                modifier = Modifier.padding(vertical = 16.dp),
                color = Color.DarkGray.copy(alpha = 0.5f)
            )

            RewardsItem(
                title = "coins",
                value = state.value.coins.toString(),
                onClick = { onAction(UserActions.onCoinsClick) }
            )

            Divider(
//                modifier = Modifier.padding(vertical = 16.dp),
                color = Color.DarkGray.copy(alpha = 0.5f)
            )

            RewardsItem(
                title = "win upto Rs 1000",
                subtitle = "refer and earn",
                onClick = { onAction(UserActions.onReferralClick) }
            )

            Spacer(modifier = Modifier.height(16.dp))

            SectionHeader(title = "TRANSACTIONS & SUPPORT")

            Spacer(modifier = Modifier.height(16.dp))

            RewardsItem(
                title = "all transactions",
                onClick = { onAction(UserActions.onTransactionClick) }
            )
        }
    }
}

@Composable
private fun ProfileTopBar(
    onBackClick: () -> Unit,
    onSupportClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onBackClick) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
            )
        }

        Text(
            text = "Profile",
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        OutlinedButton(
            onClick = onSupportClick,
            border = BorderStroke(width = 1.dp, color = Color.DarkGray),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.Gray
            ),
            shape = MaterialTheme.shapes.small
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.outline_message_24),
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    text = "support",
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }
    }
}

@Composable
private fun ProfileHeader(
    name: String,
    memberSince: String,
    onEditClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.anime_character),
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                text = memberSince,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.Gray
                )
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        IconButton(
            onClick = onEditClick,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(width = 1.dp, color = Color.DarkGray, shape = CircleShape)
        ) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Edit Profile",
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
private fun ProfileActionItem(
    icon: @Composable () -> Unit,
    title: String,
    subtitle: String,
    showArrow: Boolean = false,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        color = Color.DarkGray.copy(alpha = 0.2f),
        shape = MaterialTheme.shapes.small
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.DarkGray.copy(alpha = 0.5f)),
                contentAlignment = Alignment.Center
            ) {
                icon()
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.Gray
                    )
                )

                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.titleMedium.copy(
                    )
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            if (showArrow) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = null,
                )
            }
        }
    }
}

@Composable
private fun ProfileStatsItem(
    icon: @Composable () -> Unit,
    title: String,
    action: String? = null,
    actionColor: Color = Color.Gray,
    value: String,
    onClicked: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClicked)
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        icon()

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Color.Gray
            )
        )

        if (action != null) {
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "•",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.Gray
                )
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = action,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = actionColor
                )
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge.copy(
            )
        )

        Spacer(modifier = Modifier.width(12.dp))

        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = null,
            modifier = Modifier.size(16.dp)
        )
    }
}

@Composable
private fun SectionHeader(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.labelMedium.copy(
            color = Color.Gray,
            letterSpacing = 1.sp
        )
    )
}

@Composable
private fun RewardsItem(
    title: String,
    subtitle: String? = null,
    value: String? = null,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge.copy(
                )
            )

            if (subtitle != null) {
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.Gray
                    )
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        if (value != null) {
            Text(
                text = value,
                style = MaterialTheme.typography.bodyLarge.copy(
                )
            )

            Spacer(modifier = Modifier.width(12.dp))
        }

        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = null,
            modifier = Modifier.size(16.dp)
        )
    }
}